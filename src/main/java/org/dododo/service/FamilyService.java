package org.dododo.service;

import org.dododo.entity.family;
import org.dododo.mapper.FamilyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {
    @Autowired
    FamilyMapper familyMapper;

    public int insertFamilyMember(family family) throws DataAccessException {
        return familyMapper.insertFamilyMember(family);
    }

    public int deleteFamilyMember(String name) throws DataAccessException {
        return familyMapper.deleteFamilyMember(name);
    }

    public family getByName(String name) throws DataAccessException {
        return familyMapper.getByName(name);
    }
}
