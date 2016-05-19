/*
  Copyright 2016 José Luis De la Cruz Morales joseluis.delacruz@gmail.com

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

package com.jos.dem.jmailer.service.impl

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Value

import com.jos.dem.jmailer.command.MessageCommand
import com.jos.dem.jmailer.service.EmailerFormatter
import com.jos.dem.jmailer.enums.MessageType

@Service
class EmailerFormatterImpl implements EmailerFormatter{

  @Value('${email.contact}')
  String contact

  MessageCommand format(MessageCommand command){
    if(command.type && MessageType."${command.type}".equals(MessageType.REGISTER)){
      command.email = contact
      command.message = "${command.message} Reply to: ${command.emailContact}, source: ${command.source}"
      return command
    }
    command.message = "${command.message}, Thank you for using Jmailer!"
    return command
  }

}
