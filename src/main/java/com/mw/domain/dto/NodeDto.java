package com.mw.domain.dto;

import com.mw.domain.node.enttiy.Node;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

public class NodeDto {

    private NodeDto() {}

    public static NodeInfoDto nodeToNodeInfoDto(Node node) {
        return new NodeInfoDto(node.getId(), node.getLatitude(), node.getLongitude(), node.getName());
    }

    @Getter
    public static class NodeInfoDto {

        @Schema
        private Long id;
        @Schema
        private String latitude;
        @Schema
        private String longitude;

        @Schema
        private String name;

        @Builder
        public NodeInfoDto(Long id, String latitude, String longitude, String name) {
            this.id = id;
            this.latitude = latitude;
            this.longitude = longitude;
            this.name = name;
        }
    }

    @Getter
    public static class MapNodeDto {
        @Schema
        private Long nodeId;

        private NodeInfoDto node;

        @Builder
        public MapNodeDto(Node node) {
            this.nodeId = node.getId();
            this.node = new NodeInfoDto(node.getId(), node.getLatitude(), node.getLongitude(), node.getName());
        }
    }

    @Getter
    public static class NodeNameDto {
        @Schema
        private String name;

        public NodeNameDto(String name) {
            this.name = name;
        }
    }
}
