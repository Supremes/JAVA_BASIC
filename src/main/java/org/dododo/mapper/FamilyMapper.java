package org.dododo.mapper;

import org.dododo.entity.family;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyMapper {
    int insertFamilyMember(family family) throws DataAccessException;

    int deleteFamilyMember(String name) throws DataAccessException;

    family getByName(String name) throws DataAccessException;
}
