package com.silentsunshine.blueprintsystem.vo.flowchart;

import com.silentsunshine.blueprintsystem.entity.Node;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhouqichun
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NodeModel {
    private String id;
    private Text text;
    private String type;
    private int x;
    private int y;
    private NodeProperties properties;

    public NodeModel(Node node) {
        this.id = node.getId();
        this.text = new Text(node.getTextX(), node.getTextY(), node.getTitle());
        this.type = node.getType();
        this.x = node.getX();
        this.y = node.getY();
        List<String> checkers = Arrays.stream(node.getCheckers().split(","))
                .filter(checker -> checker != null && ! checker.isEmpty())
                .collect(Collectors.toList());
        this.properties = new NodeProperties(node.getDescription(), node.getStatus(), checkers);
    }
}
