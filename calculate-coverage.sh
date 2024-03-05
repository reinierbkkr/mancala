coverage=$(grep -oE 'Line Coverage: ([0-9.]+)%')
total_coverage=$(echo $coverage | awk '{ total += $1 } END { print total }')
echo "Total Coverage: ${total_coverage}%"