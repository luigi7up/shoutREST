/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoutplatform.domain;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  A week entity class between relations Group and Question
 * @author luka.eterovic
 */
@XmlRootElement
public class GroupQuestion {
   
    
    private final Group group;
    private final List<Question> questions;

    public GroupQuestion(Group group, List<Question> questions) {
        this.group = group;
        this.questions = questions;
    }

    public Group getGroup() {
        return group;
    }

    public List<Question> getQuestions() {
        return questions;
    }

   

    
}
