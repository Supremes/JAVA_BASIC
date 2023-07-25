package org.dododo.controller;

import org.dododo.entity.Family;
import org.dododo.model.vo.ResultVO;
import org.dododo.service.FamilyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FamilyController {
    @Autowired
    FamilyService familyService;
    private static final Logger logger = LoggerFactory.getLogger(FamilyController.class);

    @PostMapping("family/insert")
    public ResultVO<?> insertFamilyMember(@RequestBody Family family) {
        int result;
        try {
            result = familyService.insertFamilyMember(family);
        } catch (DataAccessException exception) {
            logger.error("exception: {}", exception.getMessage());
            return ResultVO.error(exception.getMessage());
        }
        logger.debug("insertFamilyMember column: {} successfully ", family);
        return ResultVO.ok();
    }

    @PostMapping("family/delete")
    public ResultVO<?> deleteFamilyMember(@RequestParam String name) {
        try {
           familyService.deleteFamilyMember(name);
        } catch (DataAccessException exception) {
            logger.error("exception: {}", exception.getMessage());
            return ResultVO.error(exception.getMessage());
        }
        logger.debug("deleteFamilyMember column: {} successfully ", name);
        return ResultVO.ok();
    }

    @GetMapping("family/get")
    public ResultVO<Family> getByName(String name) {
        Family familyInfo = familyService.getByName(name);
        logger.debug("getByName family: " + familyInfo.toString());
        return ResultVO.ok(familyInfo);
    }
}
