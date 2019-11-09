INSERT INTO FOLDER (ID, CREATED, DISABLED, MODIFIED, NAME, PARENT, PATH) VALUES (1, '2019-10-21', null, '2019-10-21', 'root', null, null);
INSERT INTO FOLDER (ID, CREATED, DISABLED, MODIFIED, NAME, PARENT, PATH) VALUES (2, '2019-10-21', null, '2019-10-21', 'src', 1, '[{"id": 1, "name": "root"}]');
INSERT INTO FOLDER (ID, CREATED, DISABLED, MODIFIED, NAME, PARENT, PATH) VALUES (3, '2019-10-21', null, '2019-10-21', 'main', 2, '[{"id": 1, "name": "root"},{"id": 2, "name": "src"}]');
INSERT INTO FOLDER (ID, CREATED, DISABLED, MODIFIED, NAME, PARENT, PATH) VALUES (4, '2019-10-21', null, '2019-10-21', 'java', 3, '[{"id": 1, "name": "root"},{"id": 2, "name": "src"},{"id": 3, "name": "main"}]');
INSERT INTO FOLDER (ID, CREATED, DISABLED, MODIFIED, NAME, PARENT, PATH) VALUES (5, '2019-10-21', null, '2019-10-21', 'resources', 3, '[{"id": 1, "name": "root"},{"id": 2, "name": "src"},{"id": 3, "name": "main"}]');

INSERT INTO FILE (ID, CREATED, DISABLED, MODIFIED, NAME, CONTENT, SIZE, FOLDER, PATH) VALUES (1, '2019-10-21', null, '2019-10-21', 'index.html', '<html></html>', 1024, 3, '[{"id": 1, "name": "root"},{"id": 2, "name": "src"},{"id": 3, "name": "main"}]');
INSERT INTO FILE (ID, CREATED, DISABLED, MODIFIED, NAME, CONTENT, SIZE, FOLDER, PATH) VALUES (2, '2019-10-21', null, '2019-10-21', 'folders.html', '<html></html>', 1024, 3, '[{"id": 1, "name": "root"},{"id": 2, "name": "src"},{"id": 3, "name": "main"}]');
INSERT INTO FILE (ID, CREATED, DISABLED, MODIFIED, NAME, CONTENT, SIZE, FOLDER, PATH) VALUES (3, '2019-10-21', null, '2019-10-21', 'images.html', '<html></html>', 1024, 3, '[{"id": 1, "name": "root"},{"id": 2, "name": "src"},{"id": 3, "name": "main"}]');
INSERT INTO FILE (ID, CREATED, DISABLED, MODIFIED, NAME, CONTENT, SIZE, FOLDER, PATH) VALUES (4, '2019-10-21', null, '2019-10-21', 'files.html', '<html></html>', 1024, 3, '[{"id": 1, "name": "root"},{"id": 2, "name": "src"},{"id": 3, "name": "main"}]');
INSERT INTO FILE (ID, CREATED, DISABLED, MODIFIED, NAME, CONTENT, SIZE, FOLDER, PATH) VALUES (5, '2019-10-21', null, '2019-10-21', 'profile.html', '<html></html>', 1024, 3, '[{"id": 1, "name": "root"},{"id": 2, "name": "src"},{"id": 3, "name": "main"}]');
INSERT INTO FILE (ID, CREATED, DISABLED, MODIFIED, NAME, CONTENT, SIZE, FOLDER, PATH) VALUES (6, '2019-10-21', null, '2019-10-21', 'calendar.html', '<html></html>', 1024, 3, '[{"id": 1, "name": "root"},{"id": 2, "name": "src"},{"id": 3, "name": "main"}]');
INSERT INTO FILE (ID, CREATED, DISABLED, MODIFIED, NAME, CONTENT, SIZE, FOLDER, PATH) VALUES (7, '2019-10-21', null, '2019-10-21', 'scheduler.html', '<html></html>', 1024, 3, '[{"id": 1, "name": "root"},{"id": 2, "name": "src"},{"id": 3, "name": "main"}]');
INSERT INTO FILE (ID, CREATED, DISABLED, MODIFIED, NAME, CONTENT, SIZE, FOLDER, PATH) VALUES (8, '2019-10-21', null, '2019-10-21', 'style.css', 'html, body {font: arial; color: red}', 1024, 3, '[{"id": 1, "name": "root"},{"id": 2, "name": "src"},{"id": 3, "name": "main"}]');
INSERT INTO FILE (ID, CREATED, DISABLED, MODIFIED, NAME, CONTENT, SIZE, FOLDER, PATH) VALUES (9, '2019-10-21', null, '2019-10-21', 'app.js', 'alert("ok....");', 1024, 3, '[{"id": 1, "name": "root"},{"id": 2, "name": "src"},{"id": 3, "name": "main"}]');

INSERT INTO ENDPOINT (ID, VERB, URI, DISABLED) VALUES (1, 'GET', 'https://httpbin.org/get', null);

INSERT INTO FIELD (ID, NAME, DISABLED, ENDPOINT) VALUES (1, 'id', null, 1);
INSERT INTO FIELD (ID, NAME, DISABLED, ENDPOINT) VALUES (2, 'descr', null, 1);