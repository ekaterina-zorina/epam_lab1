package by.epam.tour_agency.service.impl;

import by.epam.tour_agency.bean.AuthorizationInfo;
import by.epam.tour_agency.dao.UserDAO;
import by.epam.tour_agency.dao.exception.DAOException;
import by.epam.tour_agency.dao.factory.DAOFactory;
import by.epam.tour_agency.service.UserService;
import by.epam.tour_agency.service.exception.ServiceException;

/**
 * Class implements logic of user authorization.
 */
public class UserServiceImpl implements UserService {

    /**
     * Authorization.
     *
     * @param authInfo object containing login and password
     * @return true if authorization was successful and false if not
     * @throws ServiceException if login is null or empty, or DAOException has occurred
     */
    @Override
    public boolean signIn(AuthorizationInfo authInfo) throws ServiceException {
        if (authInfo.getLogin() == null || authInfo.getLogin().isEmpty()) {
            throw new ServiceException("Incorrect login");
        }

        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoFactory.getUserDAO();

            if (userDAO.signIn(authInfo)) {
                return true;
            }
            return false;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void signOut(AuthorizationInfo authInfo) throws ServiceException {

    }
}
