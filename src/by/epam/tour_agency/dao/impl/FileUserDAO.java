package by.epam.tour_agency.dao.impl;

import by.epam.tour_agency.bean.AuthorizationInfo;
import by.epam.tour_agency.dao.UserDAO;
import by.epam.tour_agency.dao.exception.DAOException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class to access a file with user login and password.
 */
public class FileUserDAO implements UserDAO {

    /**
     * Authorization.
     *
     * @param authInfo object containing login and password
     * @return true if authorization was successful and false if not
     * @throws DAOException if file cannot be found or I/O exception has occurred
     */
    @Override
    public boolean signIn(AuthorizationInfo authInfo) throws DAOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("resources\\AuthInfo.txt"))) {
            String s = reader.readLine();

            if (s != null) {
                String[] info = s.split(" ");
                AuthorizationInfo infoFromFile = new AuthorizationInfo(info[0], info[1]);

                if (authInfo.equals(infoFromFile)) {
                    return true;
                }
            }

            return false;

        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }
}
