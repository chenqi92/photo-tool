package cn.allbs.phototool.service.cm.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.allbs.phototool.dao.cm.CmPersonDao;
import cn.allbs.phototool.entity.cm.CmPersonEntity;
import cn.allbs.phototool.dto.cm.CmPersonDTO;
import cn.allbs.phototool.vo.cm.CmPersonVO;
import cn.allbs.phototool.service.cm.CmPersonService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * (cm_person)表服务实现类
 *
 * @author chenqi
 * @since 2024-04-07 10:33:31
 */
@Service("cmPersonService")
@RequiredArgsConstructor
public class CmPersonServiceImpl extends ServiceImpl<CmPersonDao, CmPersonEntity> implements CmPersonService {

    private final CmPersonDao cmPersonDao;

    /**
     * 分页查询所有数据
     *
     * @param page        分页参数
     * @param cmPersonDTO 查询参数
     * @return 指定页码和条数的数据
     */
    @Override
    public IPage<CmPersonVO> queryPage(Page<CmPersonDTO> page, CmPersonDTO cmPersonDTO) {
        return this.cmPersonDao.queryList(page, cmPersonDTO);
    }

    /**
     * 查询所有数据
     *
     * @param cmPersonDTO 查询参数
     * @return 所有数据
     */
    @Override
    public List<CmPersonVO> queryList(CmPersonDTO cmPersonDTO) {
        return this.cmPersonDao.queryList(cmPersonDTO);
    }
}
