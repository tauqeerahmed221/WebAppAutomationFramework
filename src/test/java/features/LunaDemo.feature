
@tag
Feature: SignUp and login

  @tag1
  Scenario: SignUp to luna
Given Navigate to Luna HomePage
And user click on CreateAnAccount Link
And user enter FirstaName under CreateAnAccount Link
And user enter LastName under CreateAnAccount Link
And user enter Email under CreateAnAccount Link
And user enter Password under CreateAnAccount Link
And user enter ConfirmPassword under CreateAnAccount Link
And user click on the CreateAnAccount button under CreateAnAccount Link
And user Signout

@tag2
  Scenario: Sigin to luna with Same credential
Given Navigate to Luna HomePage
And user click on SignIn link
And user enter Email under SignIn link
And user enter password under SignIn link
And user click on the SignIn button under SignIn link