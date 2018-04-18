'''
Created on Apr 18, 2018

@author: Team 4
'''
import unittest
from clientside import score


class Test(unittest.TestCase):


    def testGetScore(self):
        theScore = score.Score('someone', 400)
        somescore = theScore.getScore()
        self.assertEqual(somescore, 400)
        
    def testGetName(self):
        theScore = score.Score('someone', 400)
        theName = theScore.getName()
        self.assertEqual(theName, 'someone')


if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()