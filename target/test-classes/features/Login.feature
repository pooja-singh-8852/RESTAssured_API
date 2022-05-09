Feature: Validating Place APIs

@Addplace
Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
Given Add Place Payload with "<Name>" "<Address>" "<Language>"
When user calls "AddPlaceAPI" with "POST" http request
Then the API call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And Verify place ID created maps to "<Name>" using "GetPlaceAPI" 
Examples:
					| Name | Address | Language |
					| pooja|kashipur | English  |
			#		|seema |bhopal   |spanish   |

@Deleteplace
Scenario: Verify if Delete place functionality is working
Given Deleteplace payload
When user calls "deleteplaceapi" with "POST" http request
Then the API call is success with status code 200
And "status" in response body is "OK"