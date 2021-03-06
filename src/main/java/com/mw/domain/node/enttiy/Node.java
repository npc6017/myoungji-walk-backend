package com.mw.domain.node.enttiy;

import com.mw.domain.dto.NodeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String name;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    @Builder
    public Node(NodeDto.NodeInfoDto newNode) {
        this.latitude = newNode.getLatitude();
        this.longitude = newNode.getLongitude();
    }

    public void inputName(String name) {
        this.name = name;
    }
}