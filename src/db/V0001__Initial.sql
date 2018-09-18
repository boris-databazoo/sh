CREATE TABLE allies (
	superhero_id uuid NOT NULL,
	ally_id uuid NOT NULL,
	CONSTRAINT pk_allies
		PRIMARY KEY (superhero_id, ally_id)
);

INSERT INTO allies (superhero_id, ally_id) VALUES ('60d3a33c-b643-4cf2-b248-57b61d14e61b', 'c7740c13-58b3-4311-82a9-5af55ea85bf1');

CREATE TABLE publisher (
	id uuid NOT NULL,
	name character varying NOT NULL,
	CONSTRAINT publisher_pkey
		PRIMARY KEY (id),
	CONSTRAINT uc_publisher_name
		UNIQUE (name)
);

INSERT INTO publisher (id, name) VALUES ('03c5a279-b226-402b-af3d-8a5e48708e76', 'DC');
INSERT INTO publisher (id, name) VALUES ('9fa89c88-f488-49be-acbf-f9bb04291f64', 'Marvel');

CREATE TABLE skill (
	id uuid NOT NULL,
	name character varying NOT NULL,
	CONSTRAINT skill_pkey
		PRIMARY KEY (id),
	CONSTRAINT uc_skill_name
		UNIQUE (name)
);

INSERT INTO skill (id, name) VALUES ('57ad78f4-900c-4674-a510-79a77fe14dc7', 'Supercar');
INSERT INTO skill (id, name) VALUES ('b354a4d0-bf40-429d-9cf0-c492c1e32bbf', 'Fly');
INSERT INTO skill (id, name) VALUES ('d70318d1-0da6-438a-ae35-4c3683304567', 'Never kills anyone');

CREATE TABLE skill_to_superhero (
	superhero_id uuid NOT NULL,
	skill_id uuid NOT NULL,
	CONSTRAINT pk_skill_to_superhero
		PRIMARY KEY (superhero_id, skill_id)
);

INSERT INTO skill_to_superhero (superhero_id, skill_id) VALUES ('60d3a33c-b643-4cf2-b248-57b61d14e61b', '57ad78f4-900c-4674-a510-79a77fe14dc7');
INSERT INTO skill_to_superhero (superhero_id, skill_id) VALUES ('c7740c13-58b3-4311-82a9-5af55ea85bf1', '57ad78f4-900c-4674-a510-79a77fe14dc7');
INSERT INTO skill_to_superhero (superhero_id, skill_id) VALUES ('c7740c13-58b3-4311-82a9-5af55ea85bf1', 'd70318d1-0da6-438a-ae35-4c3683304567');

CREATE TABLE superhero (
	id uuid NOT NULL,
	first_appeared date,
	name character varying NOT NULL,
	pseudonym character varying,
	publisher_id uuid NOT NULL,
	CONSTRAINT superhero_pkey
		PRIMARY KEY (id),
	CONSTRAINT uc_superhero_name
		UNIQUE (name)
);

INSERT INTO superhero (id, name, pseudonym, publisher_id) VALUES ('60d3a33c-b643-4cf2-b248-57b61d14e61b', 'Robin', 'Robin', '03c5a279-b226-402b-af3d-8a5e48708e76');
INSERT INTO superhero (id, name, publisher_id) VALUES ('c7740c13-58b3-4311-82a9-5af55ea85bf1', 'Batman', '03c5a279-b226-402b-af3d-8a5e48708e76');

CREATE INDEX ix_superhero_publisher_id
	ON superhero
	USING btree
	(publisher_id);

ALTER TABLE skill_to_superhero
	ADD CONSTRAINT fk5mkwjhodr2g64ew8n9rqot5rh
		FOREIGN KEY (superhero_id)
		REFERENCES superhero (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE superhero
	ADD CONSTRAINT fklo32kr1u74ko4hvpo0ne23agg
		FOREIGN KEY (publisher_id)
		REFERENCES publisher (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE skill_to_superhero
	ADD CONSTRAINT fkm5l4enoho1c33jbawynqnmomt
		FOREIGN KEY (skill_id)
		REFERENCES skill (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE allies
	ADD CONSTRAINT fkn8ac98xu7dytoowptktcxs7d3
		FOREIGN KEY (ally_id)
		REFERENCES superhero (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE allies
	ADD CONSTRAINT fktnla93xpbk2byhbpgjne6ptj
		FOREIGN KEY (superhero_id)
		REFERENCES superhero (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION;