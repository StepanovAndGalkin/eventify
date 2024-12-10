INSERT INTO persons (name, email, password, role)
SELECT 'Anton', 'ultro163@gmail.com', '$2a$05$Gkd8NJsbbLJrt6eXBQdDwecUpIXNGVepy.d/x59/P01teZ38Ypsou', 'ROLE_ADMIN'
WHERE NOT EXISTS (SELECT 1 FROM persons WHERE email = 'ultro163@gmail.com');