package com.silentsunshine.blueprintsystem.vo.params;

import com.silentsunshine.blueprintsystem.vo.BlueprintVO;
import com.silentsunshine.blueprintsystem.vo.UserVO;
import com.silentsunshine.blueprintsystem.vo.flowchart.EdgeModel;
import com.silentsunshine.blueprintsystem.vo.flowchart.NodeModel;
import lombok.Data;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.List;

/**
 * @author zhouqichun
 **/
@Data
public class FlowTaskParams {

    private BaseInfo baseInfo;
    private FlowChart flowChart;
    private FormData formData;
    private Permission permission;
    private List<BlueprintVO> blueprints;

    @Data
    public class BaseInfo {
        String desc;
        String title;
        String type;
    }

    @Data
    public class FlowChart {
        List<NodeModel> nodes;
        List<EdgeModel> edges;
    }

    @Data
    public class FormData {
        String formDataJson;
    }

    @Data
    public class Permission {
        List<UserVO> maintain;
        List<UserVO> statistics;
    }
}
