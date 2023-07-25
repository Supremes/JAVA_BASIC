package org.dododo.mapper;

import org.dododo.entity.Family;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyMapper {
    int insertFamilyMember(Family family) throws DataAccessException;

    int deleteFamilyMember(String name) throws DataAccessException;

    Family getByName(String name) throws DataAccessException;
}
