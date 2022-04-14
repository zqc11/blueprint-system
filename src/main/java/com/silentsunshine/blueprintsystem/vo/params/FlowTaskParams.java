package com.silentsunshine.blueprintsystem.vo.params;

import com.silentsunshine.blueprintsystem.entity.Edge;
import com.silentsunshine.blueprintsystem.entity.Node;
import com.silentsunshine.blueprintsystem.vo.BlueprintVO;
import com.silentsunshine.blueprintsystem.vo.UserVO;
import com.silentsunshine.blueprintsystem.vo.flowchart.EdgeModel;
import com.silentsunshine.blueprintsystem.vo.flowchart.NodeModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

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
    @NoArgsConstructor
    public static class FlowChart {
        List<NodeModel> nodes;
        List<EdgeModel> edges;

        public FlowChart(List<Node> nodes, List<Edge> edges) {
            if (nodes != null) {
                this.nodes = nodes.stream()
                        .map(NodeModel::new)
                        .collect(Collectors.toList());
            }
            if (edges != null) {
                this.edges = edges.stream().map(EdgeModel::new).collect(Collectors.toList());
            }
        }
    }

    @Data
    public class BaseInfo {
        String desc;
        String title;
        String type;
    }

    @Data
    public class FormData {
        String formDataJson;
    }

    @Data
    public class Permission {
        List<String> maintain;
        List<String> statistics;
    }
}
