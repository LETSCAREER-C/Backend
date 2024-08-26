INSERT INTO program (program_id, program_title, program_intro, recruit_status, recruit_start_date, recruit_end_date, program_start_date, program_end_date, dtype)
VALUES
    (1, 'Liveclass 1', 'Intro to Liveclass 1', 'RECRUITING', CURRENT_DATE - 10, CURRENT_DATE + 10, CURRENT_DATE + 1, CURRENT_DATE + 30, 'LIVECLASS'),
    (2, 'Liveclass 2', 'Intro to Liveclass 2', 'RECRUITING', CURRENT_DATE - 10, CURRENT_DATE + 10, CURRENT_DATE + 1, CURRENT_DATE + 30, 'LIVECLASS'),
    (3, 'Liveclass 3', 'Intro to Liveclass 3', 'RECRUITING', CURRENT_DATE - 10, CURRENT_DATE + 10, CURRENT_DATE + 1, CURRENT_DATE + 30, 'LIVECLASS');

-- Insert Challenge records
INSERT INTO program (program_id, program_title, program_intro, recruit_status, recruit_start_date, recruit_end_date, program_start_date, program_end_date, dtype, ot_date)
VALUES
    (4, 'Challenge 1', 'Intro to Challenge 1', 'ENDED', CURRENT_DATE - 15, CURRENT_DATE + 5, CURRENT_DATE + 5, CURRENT_DATE + 20, 'CHALLENGE',CURRENT_DATE + 23),
    (5, 'Challenge 2', 'Intro to Challenge 2', 'ENDED', CURRENT_DATE - 15,CURRENT_DATE + 5, CURRENT_DATE + 5, CURRENT_DATE + 20, 'CHALLENGE', CURRENT_DATE + 23),
    (6, 'Challenge 3', 'Intro to Challenge 3', 'RECRUITING', CURRENT_DATE - 15, CURRENT_DATE + 5, CURRENT_DATE + 5, CURRENT_DATE + 20, 'CHALLENGE', CURRENT_DATE + 23),
    (7, 'Challenge 4', 'Intro to Challenge 4', 'RECRUITING', CURRENT_DATE - 15, CURRENT_DATE + 5, CURRENT_DATE + 5, CURRENT_DATE + 20, 'CHALLENGE', CURRENT_DATE + 23);

-- Insert tags for Liveclass records
INSERT INTO program_career_tag (program_id, career_tag)
VALUES
    (1, 'CAREER_EXPLORE'),
    (1, 'DOCUMENT_PREPARE'),
    (2, 'CAREER_EXPLORE'),
    (2, 'DOCUMENT_PREPARE'),
    (3, 'CAREER_EXPLORE');

-- Insert tags for Challenge record
INSERT INTO program_career_tag (program_id, career_tag)
VALUES
    (4, 'DOCUMENT_PREPARE'),
    (4, 'INTERVIEW_PREPARE'),
    (5, 'DOCUMENT_PREPARE'),
    (6, 'CAREER_EXPLORE'),
    (7, 'DOCUMENT_PREPARE'),
    (7, 'INTERVIEW_PREPARE');