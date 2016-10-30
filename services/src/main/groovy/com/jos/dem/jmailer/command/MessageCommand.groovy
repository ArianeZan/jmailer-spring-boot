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

package com.jos.dem.jmailer.command

import com.jos.dem.jmailer.enums.MessageType

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.hibernate.validator.constraints.Email
import javax.validation.constraints.NotNull

@ApiModel(value="MessageCommand", description="Generic command to send emails")
class MessageCommand implements Command {
  @ApiModelProperty(value = "Any valid emial", allowableValues = "email@domain")
  @Email
  @NotNull
  String email
  @ApiModelProperty(value = "Email body", allowableValues = "text")
  @NotNull
  String message
  @ApiModelProperty(value = "User's name", allowableValues = "text")
  String name
  MessageType type
}

