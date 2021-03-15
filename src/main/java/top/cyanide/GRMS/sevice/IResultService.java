package top.cyanide.GRMS.sevice;

import top.cyanide.GRMS.pojo.Result;

import java.util.List;

/**
 * @author Bai
 */
public interface IResultService {
    List<Result> findAllResults(Integer uid);
}
