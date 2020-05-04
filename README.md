# A study on the impact of automatically generated tests on the genetic improvement process using Gin

This repository is a fork of the original version of Gin: https://github.com/gintool/gin

It contains an additional class for conducting a large number of experiments on Non-functional genetic improvement on a program, using automated tests as input to the GI Process, as well as some additional utilities to facilitate the experiment.

## Running the experiments
To run the experiments included in this repository and obtain datafiles with the results, follow the steps below

1. Run the python script ExperimentScriptGenerator.py. This will create an /experiments folder and generate scripts based on your machine (Linux, MacOs or Windows)

2. Go to the /experiments folder and run the script files. This will start a single experiment. 

3. Due to the high computational expense required for Genetic improvement algorithms, each experiment can take anywhere from 1 - 8hrs to run. 

4. Running these experiments will create a .csv file in the /experiments/experiment-results folder. These experiments will be named after the date and time they were completed.

## Analysis of experiment data
As part of the study, we provided an analysis of the different correlations and trends in the data. This can be replciated with different datasets using the following steps. You will require a machine with python 3.6 installed as well as a way to run the jupyter notebook with libraries such as scipy, numpy, pandas, matplotlib and seaborn installed. 

1. Copy all relavant files to the /experiments/experiment-results/data-analysis folder. If the folder does not exist, create it. 

2. in /experiments/data-analysis, open the jupyter notebook and run all the cells. This will generate the graphs which needed to analyse the data.