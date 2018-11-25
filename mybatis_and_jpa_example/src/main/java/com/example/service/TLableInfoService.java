package com.example.service;

import com.example.bean.question.ReponseMessage;
import com.example.bean.question.TLableInfo;
import com.example.common.util.JsonUtils;
import com.example.mapper.question.TLableInfoMapper;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by niejun on 2018/11/15 14:49
 */
@Service
@Transactional
public class TLableInfoService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TLableInfoMapper tLableInfoMapper;
    /**
     * 递归获取子数据
     * @param param
     * @return
     */
    public String getLabelTreeNode(String param) {
        ReponseMessage rem = null;
        try {
            JSONObject json=JSONObject.fromObject(param);
            JSONObject publicparamjson=json.getJSONObject("requestparam");
            Map parammap=new HashMap();
            parammap.put("pid",publicparamjson.getString("pid"));
            if (publicparamjson.get("labelType")!=null){
                parammap.put("labeltype",publicparamjson.getString("labelType"));
            }

            rem=new ReponseMessage();
            List<TLableInfo> lableInfoList= tLableInfoMapper.findAllByPid(parammap);
            rem.setData(lableInfoList);
            rem.setFlag(true);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("get question has some error");
            rem.setMessage("获取试题数据失败");
        }
        return JsonUtils.usefastjsoncorvetjavebean(rem);
    }
}
