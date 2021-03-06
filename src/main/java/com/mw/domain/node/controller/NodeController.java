package com.mw.domain.node.controller;

import com.mw.domain.dto.NodeDto;
import com.mw.domain.node.service.NodeService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/node")
public class NodeController {
    private final NodeService nodeService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "node 이름 입력 API", content = @Content(schema = @Schema(implementation = NodeDto.NodeInfoDto.class)))
    })
    @PostMapping
    public ResponseEntity<NodeDto.NodeInfoDto> inputNodeName(@RequestBody NodeDto.NodeInfoDto nodeNameDto) {
        return ResponseEntity.status(HttpStatus.OK).body(nodeService.inputNodeName(nodeNameDto));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "node 이름으로 검색 API", content = @Content(schema = @Schema(implementation = NodeDto.NodeInfoDto.class)))
    })
    @GetMapping
    public ResponseEntity<NodeDto.NodeInfoDto> findByNodeName(@RequestParam("name") String name) {
        NodeDto.NodeNameDto nodeNameDto = new NodeDto.NodeNameDto(name);
        return ResponseEntity.status(HttpStatus.OK).body(nodeService.findByNodeName(nodeNameDto));
    }
}
