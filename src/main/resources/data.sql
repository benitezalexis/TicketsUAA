INSERT INTO public.users
(username, enabled, "password")
VALUES('administrador', true, '$2a$10$vxu3a3eGTOBPDsNhOqTGLuhrcQUXyfY/HFJp7ILYN5umGRnruiOiW');

INSERT INTO public.users_roles
("role", username)
VALUES('ROLE_ADMIN', 'administrador');