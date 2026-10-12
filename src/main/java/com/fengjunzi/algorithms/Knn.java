package com.fengjunzi.algorithms;

import java.util.*;

public class Knn {
   static class Sample{
    double[] features;
    int lable;
    public Sample(double[] features, int lable){
        this.features = features;
        this.lable = lable;
    }
   }

   static class Neighbour{
    double distance;
    int lable;
    public Neighbour(double distance, int lable){
        this.distance = distance;
        this.lable = lable;
    }
   }

   public static double distance(double[] a, double[] b){
    if(a.length != b.length){
        throw new IllegalArgumentException("dimenssion not identical");
    }
    double sum = 0;
    for(int i =0 ;i < a.length;i++){
        double distance = a[i] - b[i];
        sum += distance * distance; 
    }
    return sum;
   }

   public static int predict(List<Sample> samples, double[] target, int k){
    if(samples == null || samples.isEmpty()){
        throw new  IllegalArgumentException("samples could not be empty");
    }
    if(k < 0 || k > samples.size()){
        throw new IllegalArgumentException("k could not be less than 0 or greater than sample size");
    }
    PriorityQueue<Neighbour> queue = new PriorityQueue<Neighbour>((a, b) -> Double.compare(b.distance, a.distance));
    for(Sample sample : samples){
        double distance = distance(sample.features, target);
        if(queue.size() < k){
            queue.offer(new Neighbour(distance, sample.lable));
        }else if(distance < queue.peek().distance){
            queue.poll();
            queue.offer(new Neighbour(distance, sample.lable));
        }
    }
    Map<Integer,Integer> votes = new HashMap<>();
    while(!queue.isEmpty()){
        votes.merge(queue.poll().lable, 1, Integer::sum);
    }
    return votes.entrySet().stream()
    .sorted(Comparator.<Map.Entry<Integer, Integer>>comparingInt(Map.Entry::getValue)
            .reversed().thenComparing(Map.Entry::getKey))
    .findFirst()
    .orElseThrow()
    .getKey();
   }
    public static void main(String[] args) {

        List<Sample> samples = Arrays.asList(

                new Sample(new double[]{1, 2}, 0),

                new Sample(new double[]{2, 3}, 0),

                new Sample(new double[]{3, 3}, 0),

                new Sample(new double[]{7, 8}, 1),

                new Sample(new double[]{8, 7}, 1),

                new Sample(new double[]{9, 8}, 1)

        );

        double[] target = {4, 4};

        int result = predict(samples, target, 3);

        System.out.println("预测结果：" + result);

    }
}
