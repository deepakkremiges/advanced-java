package com.ndml_assignment.assignment.utility;

import java.beans.JavaBean;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


@JavaBean
//@Component
public class ApiResponse {
        private String status;
        private String status_code;
        private String status_msg;
        private String _reqid;
        private String _server_ts;
    
        //constructor
        public ApiResponse(String status, String status_code, String status_msg) {
            this.status = status;
            this.status_code = status_code;
            this.status_msg = status_msg;
            this._reqid = generateRandomRequestId();
            this._server_ts = getCurrentTimestamp();
        }
         
        
        // Setter methods
        public void setStatus(String status) {
            this.status = status;
        }


        public void setStatus_code(String status_code) {
            this.status_code = status_code;
        }


        public void setStatus_msg(String status_msg) {
            this.status_msg = status_msg;
        }


        public void set_reqid(String _reqid) {
            this._reqid = _reqid;
        }


        public void set_server_ts(String _server_ts) {
            this._server_ts = _server_ts;
        }
  
        //Getter Methods
        public String getStatus() {
            return status;
        }


        public String getStatus_code() {
            return status_code;
        }


        public String getStatus_msg() {
            return status_msg;
        }


        public String get_reqid() {
            return _reqid;
        }


        public String get_server_ts() {
            return _server_ts;
        }
 
        //Generating Random_RequestId
        private String generateRandomRequestId() {
            final String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < 9;i++){
                int randomIndex = random.nextInt(characters.length());
                char randomChar = characters.charAt(randomIndex);
                sb.append(randomChar);
            }
            return sb.toString();
        }
    
        //Generating Current_TimeStamp
        private String getCurrentTimestamp() {
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            return currentTime.format(formatter);
        }


    
}
