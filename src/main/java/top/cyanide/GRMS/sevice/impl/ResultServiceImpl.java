package top.cyanide.GRMS.sevice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cyanide.GRMS.dao.ResultMapper;
import top.cyanide.GRMS.dao.ext.IResultDAO;
import top.cyanide.GRMS.pojo.Result;
import top.cyanide.GRMS.pojo.ResultExample;
import top.cyanide.GRMS.sevice.IResultService;

import java.util.List;

/**
 * @author Bai
 */
@Service
public class ResultServiceImpl implements IResultService {
    @Autowired
    private IResultDAO resultDAO;
    @Autowired
    private ResultMapper resultMapper;

    @Override
    public List<Result> findAllResults(Integer uid) {
        if (uid == null) return this.resultMapper.selectByExample(new ResultExample());
        return this.resultDAO.findAllResults(uid);
    }
}
