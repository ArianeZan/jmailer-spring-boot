/*
  Copyright 2021 Jose Morales joseluis.delacruz@gmail.com

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.jos.dem.jmailer.service.impl;

import com.jos.dem.jmailer.command.Command;
import com.jos.dem.jmailer.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@Service
@EnableJms
public class MessageServiceImpl implements MessageService {

  @Autowired private JmsTemplate jmsTemplate;

  private Logger log = LoggerFactory.getLogger(this.getClass());

  public void message(final Command command) {
    MessageCreator messageCreator =
        new MessageCreator() {

          @Override
          public Message createMessage(Session session) throws JMSException {
            ObjectMessage message = session.createObjectMessage();
            message.setObject(command);
            return message;
          }
        };

    log.info("Sending a new message");
    jmsTemplate.send("destination", messageCreator);
  }
}
