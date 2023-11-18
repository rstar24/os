#include <iostream>
#include <string>
#include <thread>
#include <vector>

void threadFunction(int id) {
  std::cout << "Thread " << id << " is running." << std::endl;
}

int main() {
  int numThreads = 5;
  std::vector<std::thread> threads;

  for (int i = 0; i < numThreads; ++i) {
    // Create threads and pass the thread function and the thread ID
    threads.push_back(std::thread(threadFunction, i));
    // Give each thread a name
    threads.back().detach();        // Detach the thread to avoid joining
    threads.back().native_handle(); // Force the creation of a new native handle
    threads.back().join();          // Join the thread to properly set its name
    std::string threadName = "Thread " + std::to_string(i);
    pthread_setname_np(threads.back().native_handle(), threadName.c_str());
  }

  std::cout << "Main thread is running." << std::endl;

  // Wait for all threads to finish
  for (std::thread &t : threads) {
    t.join();
  }

  return 0;
}
