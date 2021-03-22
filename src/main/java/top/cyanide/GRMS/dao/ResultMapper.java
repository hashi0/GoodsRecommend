package top.cyanide.GRMS.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.cyanide.GRMS.pojo.Result;
import top.cyanide.GRMS.pojo.ResultExample;

public interface ResultMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table results
     *
     * @mbg.generated Mon Mar 22 11:53:35 CST 2021
     */
    long countByExample(ResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table results
     *
     * @mbg.generated Mon Mar 22 11:53:35 CST 2021
     */
    int deleteByExample(ResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table results
     *
     * @mbg.generated Mon Mar 22 11:53:35 CST 2021
     */
    int deleteByPrimaryKey(Integer resultId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table results
     *
     * @mbg.generated Mon Mar 22 11:53:35 CST 2021
     */
    int insert(Result record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table results
     *
     * @mbg.generated Mon Mar 22 11:53:35 CST 2021
     */
    int insertSelective(Result record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table results
     *
     * @mbg.generated Mon Mar 22 11:53:35 CST 2021
     */
    List<Result> selectByExample(ResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table results
     *
     * @mbg.generated Mon Mar 22 11:53:35 CST 2021
     */
    Result selectByPrimaryKey(Integer resultId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table results
     *
     * @mbg.generated Mon Mar 22 11:53:35 CST 2021
     */
    int updateByExampleSelective(@Param("record") Result record, @Param("example") ResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table results
     *
     * @mbg.generated Mon Mar 22 11:53:35 CST 2021
     */
    int updateByExample(@Param("record") Result record, @Param("example") ResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table results
     *
     * @mbg.generated Mon Mar 22 11:53:35 CST 2021
     */
    int updateByPrimaryKeySelective(Result record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table results
     *
     * @mbg.generated Mon Mar 22 11:53:35 CST 2021
     */
    int updateByPrimaryKey(Result record);
}