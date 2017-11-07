package com.easymovie.data.repository;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.easymovie.data.config.CoreTestConfig;
import com.easymovie.data.config.PersistenceConfigTest;

/**
 * 
 */

/**
 * @author Manas Grover
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreTestConfig.class,PersistenceConfigTest.class})
@EnableAspectJAutoProxy
public abstract class BaseTest {

}
