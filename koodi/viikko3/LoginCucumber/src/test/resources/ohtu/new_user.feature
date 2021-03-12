Feature: A new user account can be created if a proper unused username and password are given


    Scenario: creation is successful with valid username and password
        Given command new is selected
        When  username "pekkak" and password "akkepe32e3ee" are entered
        Then  system will respond with "new user registered"

    Scenario: creation fails with already taken username and valid password
        Given command new is selected
        When  username "pekka" and password "dddsadsaeeew4" are entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with too short username and valid password
        Given command new is selected
        When  username "pe" and password "dddsadsaeeew4" are entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with valid username and too short password
        Given command new is selected
        When  username "pekko" and password "ddds7" are entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with valid username and password long enough but consisting of only letters
        Given command new is selected
        When  username "pekko" and password "dddshjnnhnn" are entered
        Then  system will respond with "new user not registered"

    Scenario: can login with successfully generated account
        Given command new is selected
        When  username "pekko" and password "dddshjnnhnn5" are entered
	And command login is selected
	And username "pekko" and password "dddshjnnhnn5" are entered
        Then  system will respond with "logged in"
