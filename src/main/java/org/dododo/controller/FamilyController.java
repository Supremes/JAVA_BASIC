package org.dododo.controller;

import org.dododo.entity.family;
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
    private static Logger logger = LoggerFactory.getLogger(FamilyController.class);

    @PostMapping("family/insert")
    public ResponseEntity<String> insertFamilyMember(@RequestBody family family) {
        int result;
        try {
            result = familyService.insertFamilyMember(family);
        } catch (DuplicateKeyException exception) {
            return new ResponseEntity<>("duplicate key error", HttpStatus.BAD_GATEWAY);
        }
        logger.debug("insertFamilyMember column: {} successfully ", family);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("family/delete")
    public ResponseEntity<String> deleteFamilyMember(@RequestParam String name) {
        try {
           familyService.deleteFamilyMember(name);
        } catch (DataAccessException exception) {
            logger.error("throw exception: {}", exception.toString());
            return new ResponseEntity<>("duplicate key error", HttpStatus.BAD_GATEWAY);
        }
        logger.debug("deleteFamilyMember column: {} successfully ", name);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("family/get")
    public family getByName(String name) {
        family family2 = familyService.getByName(name);
        logger.debug("getByName family: " + family2.toString());
        return family2;
    }
}
