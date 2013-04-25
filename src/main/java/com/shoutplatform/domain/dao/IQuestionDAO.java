/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoutplatform.domain.dao;
import com.shoutplatform.domain.Question;

/**
 *
 * @author luka
 */
public interface IQuestionDAO {
    public Question getQuestionById(int id);
}
