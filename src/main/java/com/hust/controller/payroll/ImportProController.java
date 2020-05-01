package com.hust.controller.payroll;

import com.hust.beans.payroll.ImportProjectInfo;
import com.hust.service.payroll.ImportProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 宁鑫
 * @date 2019/6/24
 * @time 16:44
 **/
@Controller
@RequestMapping("/salary")
public class ImportProController {

    private ImportProjectInfoService importProjectInfoService;

    @Autowired
    public ImportProController(ImportProjectInfoService importProjectInfoService) {
        this.importProjectInfoService = importProjectInfoService;
    }

    @RequestMapping(value = "/importPro")
    public String importProPage(Model model) {
        model.addAttribute("date", importProjectInfoService.getAllDate());
        return "salary/importPro/importProManagement";
    }

    /**
     * 通过部门名或者员工名搜索
     * @param searchInfo
     * @return
     */
    @RequestMapping(value = "/importPro/search", params = "wd")
    public String searchPro(@RequestParam("wd") String searchInfo, Model model){
        List<ImportProjectInfo> infos = importProjectInfoService.search(searchInfo);
        model.addAttribute("searchPros", infos);
        return "salary/importPro/searchImport";
    }

    @RequestMapping(value = "/importPro/check/{date}")
    public String checkImportPro(@PathVariable("date") String date, Model model) {
            model.addAttribute("importPros", importProjectInfoService.searchImportProInfoByDate(date));
            return "salary/importPro/importProManagement";
    }

    /**
     * 批量导入数据
     *
     * @param response
     * @param list
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "importPro/submit", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> importExcelFile(HttpServletResponse response, @RequestBody List<Map<String, String>> list) throws IOException {
        importProjectInfoService.batchCreateImportProInfo(response, list);
        Map<String, String> res = new HashMap<>(1);
        res.put("message", "success");
        return res;
    }

    /**
     * 修改导入项目
     * @param importProjectInfo
     * @return
     * @throws IOException
     */
    @RequestMapping(value="importPro/doUpdateImportPro", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> doUpdateImportPro(@RequestBody ImportProjectInfo importProjectInfo, HttpServletResponse response) throws IOException {
         importProjectInfoService.updateImportProInfo(importProjectInfo);
        Map<String, String> map = new HashMap<>(1);
        map.put("message", "success");
        return map;
    }

    /**
     * 删除导入项目
     * @return
     */
    @RequestMapping(value="importPro/doDeleteImportPro/{importDate}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> doDeleteImportProBbyDate(@PathVariable("importDate") String importDate){
        importProjectInfoService.deleteImportProInfoByDate(importDate);
        Map<String, String> map = new HashMap<>(1);
        map.put("message", "success");
        return map;
    }
}
