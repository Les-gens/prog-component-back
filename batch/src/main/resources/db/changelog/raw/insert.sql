INSERT INTO User (user_id,username, nom, prenom, password, birthday, description) VALUES (1, 'user1','billy', 'henry', '1234', '1998-10-02', 'love pancake');
INSERT INTO User (user_id,username, nom, prenom, password, birthday, description) VALUES (2, 'user2','valjean', 'jul', 'Gregoir2003', '2003-02-24', 'i prefer dog');
INSERT INTO User (user_id,username, nom, prenom, password, birthday, description) VALUES (3, 'user3','snow', 'jhon', 'A,!@lOKm234[]', '1999-12-01', 'join the dark side, we have cookies');
INSERT INTO User (user_id,username, nom, prenom, password, birthday, description) VALUES (4, 'user4','pat', 'frederic', '4321', '1978-10-12', 'love pancake');
INSERT INTO User (user_id,username, nom, prenom, password, birthday, description) VALUES (5, 'user5','gaulois', 'francois', '0000', '2003-01-23', 'love pancake');

INSERT INTO Post (post_id, title, text, user_id, private_post) VALUES (1, 'Hello world', 'Hello', 1, 1);
INSERT INTO Post (post_id, title, text, user_id, private_post) VALUES (3, 'I love cookies', 'J aime les cookies', 4, 0);
INSERT INTO Post (post_id, title, text, user_id, private_post) VALUES (4, 'manifestation', 'DITES NON AU MANIDESTATION', 2, 0);

INSERT INTO Friend (person_id, friend_id) VALUES (1, 2);
INSERT INTO Friend (person_id, friend_id) VALUES (2, 3);
INSERT INTO Friend (person_id, friend_id) VALUES (1, 3);
INSERT INTO Friend (person_id, friend_id) VALUES (4, 5);

INSERT INTO Request (requester_id, requested_id) VALUES (1, 2);