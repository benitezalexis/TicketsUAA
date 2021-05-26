/**
 * insertar usuario a la table users 
 */
INSERT INTO public.users
(username, enabled, "password")
VALUES('administrador', false, '$2a$10$vxu3a3eGTOBPDsNhOqTGLuhrcQUXyfY/HFJp7ILYN5umGRnruiOiW');

/**
 * insertar rol al administrador
 * ROLE_USER
 * ROLE_
 * ROLE_ADMIN
 */
INSERT INTO public.users_roles
("role", username)
VALUES('ROLE_ADMIN', 'administrador');