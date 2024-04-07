package cn.allbs.phototool.task;

import cn.allbs.oss.service.OssTemplate;
import cn.allbs.phototool.entity.cm.CmPersonEntity;
import cn.allbs.phototool.service.cm.CmPersonService;
import com.amazonaws.services.s3.model.S3Object;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 类 DownAllPhoto
 *
 * @author ChenQi
 * @date 2024/4/7
 */
@Slf4j
@Component
public class DownAllPhoto implements CommandLineRunner {

    @Resource
    private CmPersonService cmPersonService;

    @Resource
    private OssTemplate ossTemplate;

    @Override
    public void run(String... args) throws Exception {
        // 查询人员相关信息
        List<CmPersonEntity> persons = cmPersonService.list(Wrappers.<CmPersonEntity>query().lambda().isNull(CmPersonEntity::getHkPersonId).and(i -> i.isNotNull(CmPersonEntity::getPhotoUrl).or().isNotNull(CmPersonEntity::getPhotoUrl)));
        log.info("当前查询到人员总数:{}", persons.size());
        // 创建一个文件夹来保存图片
        Path dirPath = Paths.get("tempImages");
        if (!Files.exists(dirPath)) {
            try {
                Files.createDirectory(dirPath);
            } catch (IOException e) {
                log.error("创建文件夹失败", e);
                return;
            }
        }
        // 获取文件服务器中的文件
        persons.forEach(person -> {
            try (S3Object s3Object = ossTemplate.getObject("pcfiles", person.getPhotoUrl())) {
                InputStream inputStream = s3Object.getObjectContent();
                String fileName = person.getName() + "_" + person.getIdCard() + ".jpg";
                log.info("下载文件:{}", fileName);
                Path outputPath = dirPath.resolve(fileName);
                Files.copy(inputStream, outputPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                log.error("文件下载失败", e);
            }
        });
        // 创建一个ZIP文件
        Path zipPath = Paths.get("D:\\images.zip");
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath.toFile()))) {
            Files.walk(dirPath).filter(path -> !Files.isDirectory(path)).forEach(path -> {
                ZipEntry zipEntry = new ZipEntry(dirPath.relativize(path).toString());
                try {
                    zos.putNextEntry(zipEntry);
                    Files.copy(path, zos);
                    zos.closeEntry();
                } catch (IOException e) {
                    log.error("添加文件到ZIP失败", e);
                }
            });
        } catch (IOException e) {
            log.error("创建ZIP文件失败", e);
        }
    }
}
