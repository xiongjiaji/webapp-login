package com.kyle.webapp.controller;

import com.kyle.webapp.dao.IdentityDAO;
import com.kyle.webapp.entity.Identity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Xiong on 2017/5/9.
 */
@RestController
@RequestMapping(value = "/identity")
public class IdentityController {

    @Autowired
    private IdentityDAO identityDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/{identityId}")
    public Identity getIdentity(@PathVariable long identityId)  {
        Identity identity = identityDAO.get(identityId);
        if (identity != null) {
            return identity;
        } else {
            throw new NullPointerException("identity is null!");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@RequestBody Identity identity) {
        identityDAO.save(identity);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateUser(@RequestBody Identity identity) {
        if (null == identityDAO.get(Long.valueOf(identity.getId()))) {
            throw new NullPointerException("user doesn't exist!");
        } else {
            identityDAO.update(identity);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{identityId}")
    public void deleteUser(@PathVariable long identityId) {
        identityDAO.delete(identityId);
    }

}
