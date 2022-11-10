SET search_path TO panda;

INSERT INTO mails VALUES
(1, 'test-Mail-1'),
(2, 'test-Mail-2');

INSERT INTO owners VALUES
(1, 'test-Owner-1'),
(2, 'test-Owner-2');

INSERT INTO types VALUES
(1, 'all'),
(2, 'socials'),
(3, 'games'),
(4, 'work'),
(5, 'temp'),
(6, 'trash');

INSERT INTO accounts VALUES
(1, 'test-name-1', 'test-account-1', 'test-password-1','test-link-1','test-description-1',1,1,1,current_timestamp),
(2, 'test-name-2', 'test-account-2', 'test-password-2','test-link-2','test-description-2',2,2,1,current_timestamp);
