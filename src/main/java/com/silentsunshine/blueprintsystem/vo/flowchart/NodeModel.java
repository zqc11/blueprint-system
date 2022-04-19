package com.silentsunshine.blueprintsystem.vo.flowchart;

import com.silentsunshine.blueprintsystem.entity.Node;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.silentsunshine.blueprintsystem.utils.Parser.parseUserId;

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
        List<String> checkers = parseUserId(node.getCheckers());
        List<String> operations = parseUserId(node.getOperations());
        List<String> hasPassed = parseUserId(node.getHasPassed());
        List<String> hasRejected = parseUserId(node.getHasRejected());
        this.properties = new NodeProperties(node.getDescription(), node.getStatus(), node.getOrderNum(), node.getRejectTo(), checkers, operations, hasPassed, hasRejected);
    }
}
