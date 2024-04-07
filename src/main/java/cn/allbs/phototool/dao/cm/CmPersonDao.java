package cn.allbs.phototool.dao.cm;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.allbs.phototool.entity.cm.CmPersonEntity;
import cn.allbs.phototool.dto.cm.CmPersonDTO;
import cn.allbs.phototool.vo.cm.CmPersonVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (cm_person)表数据库访问层
 *
 * @author chenqi
 * @since 2024-04-07 10:33:31
 */
@Mapper
public interface CmPersonDao extends BaseMapper<CmPersonEntity> {

    /**
     * 分页查询所有数据
     *
     * @param page        分页参数
     * @param cmPersonDTO 查询参数
     * @return IPage<CmPersonVO>
     */
    IPage<CmPersonVO> queryList(Page<CmPersonDTO> page, @Param("cmPersonDTO") CmPersonDTO cmPersonDTO);

    /**
     * 查询所有数据
     *
     * @param cmPersonDTO 查询参数
     * @return List<CmPersonVO>
     */
    List<CmPersonVO> queryList(@Param("cmPersonDTO") CmPersonDTO cmPersonDTO);
}
