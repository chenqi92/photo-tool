package cn.allbs.phototool.service.cm;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.allbs.phototool.entity.cm.CmPersonEntity;
import cn.allbs.phototool.dto.cm.CmPersonDTO;
import cn.allbs.phototool.vo.cm.CmPersonVO;

import java.util.List;

/**
 * (cm_person)表服务接口
 *
 * @author chenqi
 * @since 2024-04-07 10:33:31
 */
public interface CmPersonService extends IService<CmPersonEntity> {

    /**
     * 分页查询所有数据
     *
     * @param page        分页参数
     * @param cmPersonDTO 查询参数
     * @return IPage<CmPersonVO> cmPersonDTO
     */
    IPage<CmPersonVO> queryPage(Page<CmPersonDTO> page, CmPersonDTO cmPersonDTO);

    /**
     * 查询所有数据
     *
     * @param cmPersonDTO 查询参数
     * @return List<CmPersonVO>
     */
    List<CmPersonVO> queryList(CmPersonDTO cmPersonDTO);
}
