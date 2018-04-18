'''
Created on Apr 17, 2018

@author: timbe
'''

import os
from clientside import score

class HighScores(object):
    '''
    classdocs
    '''


    def __init__(self, filename):
        '''
        Constructor
        '''
        try:
            self.myFile = open(os.path.join(os.getcwd(), filename))
        except:
            raise FileNotFoundError("Score board file name is invalid")
        
        self.myScores = []
        for line in self.myFile.readlines():
            splitLine = str(line).split(sep=',')
            self.myScores.append(score.Score(splitLine[0], int(splitLine[1])))
            
    def getScores(self):
        return self.myScores
    
    def sortScores(self):
        self.myScores.sort()
        
        