##### 1] Explain Boosting Ensemble method with diagram
Boosting is a ensemble machine learning technique that trains models sequentially rather than in parallel like in bagging
Every model specifically seeks to fix the errors made by their predecessors. Weights of misclassified or difficult to predict examples are increased and a strong learner is made from multiple weak learners

```
                                                                                 ┌──────────────────────────────┐
┌──────────────────┐       ┌──────────────────┐       ┌──────────────────┐ ...   │                              │
│  Weak Learner 1  ┼──────►│  Weak Learner 2  ┼──────►│  Weak Learner 3  ┼──────►│   Final Strong Learner       │
└──────────────────┘       └──────────────────┘       └──────────────────┘       │                              │
                                                                                 └──────────────────────────────┘
```

##### 2] How does AdaBoost work?
Adaboost stands for Adaptive Boost, it builds a series of weak models (usually decision stumps with one split) and where each new model tries to fix the mistakes of predecessor.
1. Every data point is assigned equal weight at first
2. Base model like decision stump is trained on data
3. Uncertain (50:50 ahh) or Misclassified Weights are increased,  correct weights are decreased
4. Models that perform poorly are given lower influence and ones that perform well are given higher influence
5. Steps 2 to 4 are repeated N times and now a single strong model is formed

##### 3] How does boosting differ from bagging?

| Parameter              | Bagging                                           | Boosting                                                                         |
| ---------------------- | ------------------------------------------------- | -------------------------------------------------------------------------------- |
| **Training**           | Parallel Manner                                   | Serially (Sequentially)                                                          |
| **Objective**          | Reduce Variance                                   | Reduce B                                                                         |
| **Weighting Policy**   | Sampled randomly with replacement (Bootstrapping) | Misclassifications get higher weight                                             |
| **Training Speed**     | Faster as Parallel                                | Slower as its Serial, must wait for previous model to train                      |
| **Outlier Protection** | High as they have minimal impact                  | Very low as outliers have massive weight gain, leading to wasted info gain  data |
| **Examples**           | Random Forest                                     | Adaboost,                                                                        |

##### 4] What is the role of `n_estimators`? 
`n_estimators` in boosting is the total number of iterations (models) boosting will be performed on i.e. number of models and looping through the process of training weak learners.
Too low of a value will cause underfitting and too high of a value will cause overfitting

In bagging it determines how many independent trees are built in parallel. Increasing number of `n_estimators` here leads to diminishing returns instead of overfitting.

##### 5] What is the role of `learning_rate`?
`learning_rate` is a hyperparameter controlling how much each model contributes to final prediction. Determines magnitude of corrections/fixes made by succeeding models.

If rate is too high, model obviously learns quicker but may overshoot an optimal solution and/or overfit.
If rate is too low, model takes smaller steps but takes longer to train. However it is more robust and accurate.

`learning_rate` and `n_estimators` are meant to be configured inversely proportional to each other for best results.


##### 6] Explain stacking ensemble method with diagram.
Stacking is a ensemble learning method where multiple models of different types like for example KNN, Decision Tree, Logistic Regression, etc are trained independently. These are called as base or level-1 models. 
Now instead of averaging their outputs or majority vote, a final model called as meta-model or level-2 model is trained to best combine their predictive abilities for greater performance.

The final model is usually a simpler model like linear or logistic regression

```
                    +----------------------------------+                      
                    |                                  |                      
                    |    Original Dataset              |                      
                    |                                  |                      
                    +----------------+-----------------+                      
                                     |                                        
          +--------------------------+---------------------------+            
          |                          |                           |            
          |                          |                           |            
          |                          |                           |            
+---------v-----------+   +----------v----------+  +-------------v----------+ 
|                     |   |                     |  |                        | 
|  KNN (Base Model 1) |   | Adaboost (BM 2)     |  |  Decision (BM 3)       | 
|                     |   |                     |  |                        | 
+---------+-----------+   +----------+----------+  +-------------+----------+ 
          |                          |                           |            
          |                          |                           |            
          v                          v                           v            
  Output (Prediction 1)      Output (Prediction 2)       Output (Prediction 3)
          |                           |                            |          
          |                           |                            |          
          +---------------------------+----------------------------+          
                                      |                                       
                       +--------------v------------------+                    
                       |                                 |                    
                       | New dataset / meta-features     |                    
                       |                                 |                    
                       +---------------+-----------------+                    
                                       |                                      
                                       |                                      
                                       v                                      
                        +--------------------------------+                    
                        |                                |                    
                        | Meta Model (eg: Logistic Regre |                    
                        |    ssion)                      |                    
                        |                                |                    
                        +---------------+----------------+                    
                                        |                                     
                                        |                                     
                                        v                                     
                          Final Strong Prediction from Meta-Model             
```

##### 7] Explain voting classifier with hard and soft voting.
A voting classifier is an ensemble learning technique where "votes" are placed by the training models which are trained in parallel fashion independently. This type of ensemble method also combines different types of algorithms like KNN, Decision Tree, Logistic Regression, etc as the base learners.

Hard voting is when the models give a discrete concrete vote like class A, class B, etc or 0 and 1. Output with highest vote count wins.

Soft voting is when the models account for probability and confidence and hence return a probability value. The voting classifier sums up these values and the class with highest average probability wins.
