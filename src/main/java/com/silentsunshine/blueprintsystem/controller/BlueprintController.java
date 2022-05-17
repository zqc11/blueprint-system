package com.silentsunshine.blueprintsystem.controller;

import com.silentsunshine.blueprintsystem.service.IBlueprintService;
import com.silentsunshine.blueprintsystem.vo.Result;
import com.silentsunshine.blueprintsystem.vo.params.BlueprintParams;
import com.silentsunshine.blueprintsystem.vo.params.DrawDataParams;
import com.silentsunshine.blueprintsystem.vo.params.SnapDataParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
@RestController
public class BlueprintController {
    @Autowired
    IBlueprintService blueprintService;

    @GetMapping("/getPdfFile/{filename}")
    @CrossOrigin
    public void getPdfFile(@PathVariable("filename") String filename, HttpServletResponse response) {
        String path = "src/temp/";
        File file = new File(path + filename);
        byte[] buffer;
        try {
            buffer = Files.readAllBytes(Paths.get(file.toURI()));

            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Disposition", "inline;attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            // 告知浏览器文件的大小
            response.addHeader("Content-Length", "" + file.length());
            response.addHeader("Access-Control-Allow-Origin", "*");
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/saveDrawData")
    public Result saveDrawData(@RequestBody DrawDataParams drawDataParams) {
        blueprintService.updateDrawData(drawDataParams.getId(), drawDataParams.getDrawData());
        return Result.success(null);
    }

    @PostMapping("/saveSnapData")
    public Result saveSnapData(@RequestBody SnapDataParams snapDataParams) {
        blueprintService.updateSnapData(snapDataParams.getId(), snapDataParams.getSnapData());
        return Result.success(null);
    }

    @GetMapping("/getDrawData/{id}")
    public Result getDrawData(@PathVariable("id") int id) {
        String data = blueprintService.getDrawData(id);
        return Result.success(data);
    }

    @GetMapping("/getSnapData/{id}")
    public Result getSnapData(@PathVariable("id") int id) {
        String data = blueprintService.getSnapData(id);
        return Result.success(data);
    }

    @PostMapping("/saveBlueprints")
    public Result saveBlueprints(@RequestBody BlueprintParams blueprintParams) {
        blueprintService.insertBlueprint(blueprintParams.getBlueprint(), blueprintParams.getTaskId());
        return Result.success(null);
    }
}
