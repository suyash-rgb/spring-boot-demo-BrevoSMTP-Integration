# Brevo Integration in Spring Boot

A Spring Boot project demonstrating how to send transactional and HTML emails via Brevo SMTP in just three simple steps.

---

## Table of Contents

- Overview  
- Features  
- Prerequisites  
- Getting Started  
- Configuration  
- Running the Application  
- API Endpoints  
- Sample Requests  
- Customizing Email Templates  
- Testing  
- Deployment  
- Contributing  
- License  
- Acknowledgments  

---

## Overview

This repository shows how to integrate Brevo SMTP into a Spring Boot application for sending both plain text and HTML transactional emails. You’ll learn how to:

- Configure SMTP settings in Spring Boot  
- Implement a mail service and controller  
- Send emails via REST endpoints  
- Verify delivery and troubleshoot authentication issues  

---

## Features

- SMTP configuration using Spring Boot starter-mail  
- Service for sending simple text and HTML emails  
- REST controller with `/send-text` and `/send-html` endpoints  
- Externalized configuration via `application.properties`  
- Sample DTO for email requests  
- Troubleshooting tips for common SMTP errors  

---

## Prerequisites

- Java 17 or higher  
- Maven 3.6+  
- A Brevo account with SMTP platform activated  
- An SMTP key from Brevo dashboard  
- IDE or code editor (IntelliJ IDEA, VS Code, etc.)  

---

## Getting Started

1. Clone the repository  

   ```bash
   git clone https://github.com/suyash-rgb/spring-boot-demo-BrevoSMTP-Integration.git
   cd brevo-springboot-integration
   ```

2. Build the project  

   ```bash
   mvn clean install
   ```

---

## Configuration

1. In the Brevo dashboard, navigate to **SMTP & API** and copy your SMTP credentials.  
2. Open `src/main/resources/application.properties` and add:

   ```properties
   spring.mail.host=smtp-relay.brevo.com
   spring.mail.port=587
   spring.mail.username=your_brevo_email@example.com
   spring.mail.password=your_smtp_key
   spring.mail.properties.mail.smtp.auth=true
   spring.mail.properties.mail.smtp.starttls.enable=true
   ```

3. (Optional) Use environment variables or a Spring Cloud Config server to keep credentials out of source control.

---

## Running the Application

Start the Spring Boot application:

```bash
mvn spring-boot:run
```

You should see logs indicating the mail sender has initialized successfully.

---

## API Endpoints

- `POST /api/email/send-text`  
  Sends a plain text email.

- `POST /api/email/send-html`  
  Sends an HTML email.

---

## Sample Requests

### Plain Text Email

```bash
curl -X POST http://localhost:8080/api/email/send-text \
  -H "Content-Type: application/json" \
  -d '{
        "to": "recipient@example.com",
        "subject": "Test Text Email",
        "body": "Hello from Brevo SMTP!"
      }'
```

### HTML Email

```bash
curl -X POST http://localhost:8080/api/email/send-html \
  -H "Content-Type: application/json" \
  -d '{
        "to": "recipient@example.com",
        "subject": "Test HTML Email",
        "body": "<h1>Welcome!</h1><p>Your order has shipped.</p>"
      }'
```

---

## Customizing Email Templates

- Use Thymeleaf or FreeMarker for dynamic HTML templates.  
- Store templates under `src/main/resources/templates/`.  
- Inject `SpringTemplateEngine` into your mail service and process templates before sending.

---

## Testing

- Write unit tests for `EmailService` using Mockito to mock `JavaMailSender`.  
- Use GreenMail for integration tests to simulate an SMTP server and verify email contents.

---

## Deployment

- Package as a JAR with `mvn clean package`.  
- Deploy to any cloud platform (Heroku, AWS Elastic Beanstalk, Azure App Service).  
- Remember to set SMTP credentials as environment variables in your production environment.

---

## Contributing

Contributions are welcome! To propose changes:

1. Fork the repository  
2. Create a feature branch (`git checkout -b feature-name`)  
3. Commit your changes (`git commit -m "Add new feature"`)  
4. Push to the branch (`git push origin feature-name`)  
5. Open a Pull Request  

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Acknowledgments

- Brevo (Sendinblue) for providing a robust email API  
- Spring Boot community for starter-mail support  
- GreenMail for SMTP testing library  

