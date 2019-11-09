package by.epam.tour_agency.dao;

import by.epam.tour_agency.bean.AuthorizationInfo;
import by.epam.tour_agency.dao.exception.DAOException;

/**
 * Interface to access User DAO.
 */
public interface UserDAO {
    /**
     * Authorization.
     *
     * @param authInfo object containing login and password
     * @return true if authorization was successful and false if not
     * @throws DAOException
     */
    boolean signIn(AuthorizationInfo authInfo) throws DAOException;
}
