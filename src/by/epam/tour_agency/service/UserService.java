package by.epam.tour_agency.service;

import by.epam.tour_agency.bean.AuthorizationInfo;
import by.epam.tour_agency.service.exception.ServiceException;

/**
 * Interface defines logic of user authorization.
 */
public interface UserService {

    /**
     * Authorization.
     *
     * @param authInfo object containing login and password
     * @return true if authorization was successful and false if not
     * @throws ServiceException
     */
    boolean signIn(AuthorizationInfo authInfo) throws ServiceException;
    void signOut(AuthorizationInfo authInfo) throws ServiceException;
}
