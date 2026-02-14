require "rake"

GRADLEW = "./gradlew"

def gradle(cmd)
  sh "#{GRADLEW} #{cmd} --info --stacktrace --rerun-tasks"
end

desc "Run all Gradle unit tests (verbose)"
task :gradle_test do
  puts "==> Running Gradle unit tests"
  gradle "test"
end

desc "Run Gradle tests without build cache"
task :gradle_test_nocache do
  puts "==> Running Gradle unit tests (no cache)"
  gradle "test --no-build-cache"
end

desc "Run a single Gradle test class (TEST=MyTest)"
task :gradle_test_one do
  test = ENV["TEST"] or abort "Usage: rake gradle_test_one TEST=MyTest"
  puts "==> Running Gradle test: #{test}"
  gradle "test --tests #{test}"
end

desc "Clean then run Gradle tests"
task :gradle_clean_test do
  puts "==> Cleaning build"
  gradle "clean"
  puts "==> Running tests"
  gradle "test"
end
